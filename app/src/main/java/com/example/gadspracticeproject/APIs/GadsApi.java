package com.example.gadspracticeproject.APIs;

import com.example.gadspracticeproject.models.LearnerHours;
import com.example.gadspracticeproject.models.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsApi {
    @GET("hours")
    Call<List<LearnerHours>> getLearnerHours();

    @GET("skilliq")
    Call<List<SkillIQ>> getSkillIq();
}
