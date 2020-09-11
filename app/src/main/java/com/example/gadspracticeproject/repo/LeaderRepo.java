package com.example.gadspracticeproject.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gadspracticeproject.APIs.GadsApi;
import com.example.gadspracticeproject.APIs.RetroClass;
import com.example.gadspracticeproject.APIs.GoogleFormApi;
import com.example.gadspracticeproject.models.LearnerHours;
import com.example.gadspracticeproject.models.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderRepo {
    private static LeaderRepo instance;
    private GadsApi mGadsApi = RetroClass.getGadsApiService();
    private GoogleFormApi mGoogleFormsApi = RetroClass.getGoogleApiService();
    private MutableLiveData<List<LearnerHours>> mLearnerHoursMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<SkillIQ>> mSkillLeadersMutableLiveData = new MutableLiveData<>();

    public static LeaderRepo getInstance() {
        if (instance == null) {
            instance = new LeaderRepo();
        }
        return instance;
    }

    private void getLearningLeaders() {
        Call<List<LearnerHours>> call = mGadsApi.getLearnerHours();
        call.enqueue(new Callback<List<LearnerHours>>() {
            @Override
            public void onResponse(Call<List<LearnerHours>> call, Response<List<LearnerHours>> response) {
                mLearnerHoursMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearnerHours>> call, Throwable t) {
            }
        });
    }

    private void getSkillIqLeaders() {
        Call<List<SkillIQ>> call = mGadsApi.getSkillIq();
        call.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                mSkillLeadersMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
            }
        });
    }

    public LiveData<List<LearnerHours>> getLearnerLeaders() {
        getLearningLeaders();
        if (mLearnerHoursMutableLiveData == null) {
            mLearnerHoursMutableLiveData = new MutableLiveData<>();
        }
        return mLearnerHoursMutableLiveData;
    }

    public LiveData<List<SkillIQ>> getSkillLeaders() {
        getSkillIqLeaders();
        if (mSkillLeadersMutableLiveData == null) {
            mSkillLeadersMutableLiveData = new MutableLiveData<>();
        }
        return mSkillLeadersMutableLiveData;
    }
}


