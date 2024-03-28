package com.vovan.restapi.mvc;

import com.vovan.restapi.notes.NoteService;
import com.vovan.restapi.notes.dto.create.CreateNoteRequest;
import com.vovan.restapi.notes.dto.create.CreateNoteResponse;
import com.vovan.restapi.notes.dto.delete.DeleteNoteResponse;
import com.vovan.restapi.notes.dto.get.GetUserNotesResponse;
import com.vovan.restapi.notes.dto.update.UpdateNoteRequest;
import com.vovan.restapi.notes.dto.update.UpdateNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public CreateNoteResponse create(Principal principal, @RequestBody CreateNoteRequest request) {
        return noteService.create(principal.getName(), request);
    }

    @GetMapping
    public GetUserNotesResponse getUserNotes(Principal principal) {
        return noteService.getUserNotes(principal.getName());
    }

    @PatchMapping
    public UpdateNoteResponse update(Principal principal, @RequestBody UpdateNoteRequest request) {
        return noteService.update(principal.getName(), request);
    }

    @DeleteMapping
    public DeleteNoteResponse delete(Principal principal, @RequestParam(name = "id") long id) {
        return noteService.delete(principal.getName(), id);
    }
}