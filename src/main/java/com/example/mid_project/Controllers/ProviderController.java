package com.example.mid_project.Controllers;


import com.example.mid_project.APIs.ApiResponse;
import com.example.mid_project.Models.Provider;
import com.example.mid_project.Models.Request;
import com.example.mid_project.Services.ProviderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/provider")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderServices providerServices;

    @GetMapping("/get")
    public ResponseEntity getAllProviders() {
        return ResponseEntity.status(200).body(providerServices.getAllProviders());
    }

    @PostMapping("/add")
    public ResponseEntity addProvider(@RequestBody Provider newProvider) {
        providerServices.addProvider(newProvider);
        return ResponseEntity.status(201).body(new ApiResponse("provider added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProvider(@PathVariable Integer id, @RequestBody Provider provider) {
        providerServices.updateProvider(id, provider);
        return ResponseEntity.status(201).body(new ApiResponse("provider updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProvider(@PathVariable Integer id) {
        providerServices.deleteProvider(id);
        return ResponseEntity.status(201).body(new ApiResponse("provider deleted"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity findProviderbyid(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(providerServices.getProviderById(id));
    }

    @PostMapping("/requestadd/{providerId}/{prjectId}")
    public ResponseEntity postRequest(@RequestBody Request request, @PathVariable Integer providerId,
                                      @PathVariable Integer prjectId) {
        providerServices.postRequest(request, providerId, prjectId);
        return ResponseEntity.status(201).body(new ApiResponse("request posted"));

    }

    @GetMapping("/type/{type}")
    public ResponseEntity searchProviderByType(@PathVariable String type) {
        return ResponseEntity.status(200).body(providerServices.searchProvidersByType(type));
    }
}
