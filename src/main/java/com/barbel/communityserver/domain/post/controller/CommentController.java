package com.barbel.communityserver.domain.post.controller;

import com.barbel.communityserver.domain.post.dto.CommentDto;
import com.barbel.communityserver.domain.post.dto.CommentSaveDto;
import com.barbel.communityserver.domain.post.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService)
    {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public void saveComment(@RequestBody CommentSaveDto commentDto)
    {
        commentService.saveComment(commentDto);
    }

    @PostMapping("/save/{parentId}")
    public void saveReComment(@PathVariable String parentId,@RequestBody CommentSaveDto commentSaveDto)
    {
        commentService.saveReComment(parentId, commentSaveDto);
    }

}
