package com.bloodDonation.board.service.config;

import com.bloodDonation.board.entities.Board;
import com.bloodDonation.board.repositories.BoardRepository;
import com.bloodDonation.commons.Utils;
import com.bloodDonation.commons.exceptions.AlertException;
import com.bloodDonation.file.service.FileDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardConfigDeleteService {

    private final BoardRepository boardRepository;
    private final BoardConfigInfoService configInfoService;
    private final FileDeleteService fileDeleteService;
    private final Utils utils;

    /**
     * 게시판 삭제
     *
     * @param bid : 게시판 아이디
     */
    public void delete(String bid) {
        Board board = configInfoService.get(bid);

        String gid = board.getGid();

        boardRepository.delete(board);

        boardRepository.flush();

        fileDeleteService.delete(gid);
    }

    public void deleteList(List<Integer> chks) {
        if (chks == null || chks.isEmpty()) {
            throw new AlertException("삭제할 게시판을 선택하세요.", HttpStatus.BAD_REQUEST);
        }

        for (int chk : chks) {
            String bid = utils.getParam("bid_" + chk);
            delete(bid);
        }
    }
}
