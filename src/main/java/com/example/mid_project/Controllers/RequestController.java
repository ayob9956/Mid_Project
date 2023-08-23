package com.example.mid_project.Controllers;

import com.example.mid_project.APIs.ApiResponse;
import com.example.mid_project.Models.Provider;
import com.example.mid_project.Models.Request;
import com.example.mid_project.Services.RequestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestServices requestServices;

    @GetMapping("/get")
    public ResponseEntity getAllRequests() {
        return ResponseEntity.status(200).body(requestServices.getAllRequests());
    }

    @PostMapping("/add")
    public ResponseEntity addRequest(@RequestBody Request newRequest) {
        requestServices.addRequest(newRequest);
        return ResponseEntity.status(201).body(new ApiResponse("Request added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRequest(@PathVariable Integer id, @RequestBody Request request) {
        requestServices.updateRequest(id, request);
        return ResponseEntity.status(201).body(new ApiResponse("Request updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id) {
        requestServices.deletePRequest(id);
        return ResponseEntity.status(201).body(new ApiResponse("Request deleted"));
    }
}
