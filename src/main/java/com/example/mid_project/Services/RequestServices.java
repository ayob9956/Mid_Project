package com.example.mid_project.Services;


import com.example.mid_project.APIs.ApiException;
import com.example.mid_project.Models.Provider;
import com.example.mid_project.Models.Request;
import com.example.mid_project.Repos.RequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServices {
    private final RequestRepo requestRepo;

    public List<Request> getAllRequests() {
        return requestRepo.findAll();
    }

    public void addRequest(Request request) {
        requestRepo.save(request);
    }

    public void updateRequest(Integer id, Request newRequest) {
        Request request = requestRepo.findRequestById(id);

        if (request == null) {
            throw new ApiException("wrong request ID ");
        }
        request.setBudget(newRequest.getBudget());
        request.setDuration(newRequest.getDuration());
        request.setProviderName(newRequest.getProviderName());
        request.setDetails(newRequest.getDetails());
        request.setIsApproved(newRequest.getIsApproved());

        requestRepo.save(request);
    }

    public void deletePRequest(Integer id) {
        Request request = requestRepo.findRequestById(id);

        if (request == null) {
            throw new ApiException("wrong request ID ");
        }

        requestRepo.delete(request);
    }
}
