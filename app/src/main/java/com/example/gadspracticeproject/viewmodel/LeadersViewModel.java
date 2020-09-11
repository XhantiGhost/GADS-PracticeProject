package com.example.gadspracticeproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gadspracticeproject.models.LearnerHours;
import com.example.gadspracticeproject.models.SkillIQ;
import com.example.gadspracticeproject.repo.LeaderRepo;

import java.util.List;

public class LeadersViewModel extends AndroidViewModel {
    private LeaderRepo mLeadersRepository;
    private LiveData<List<LearnerHours>> learnerHours;
    private LiveData<List<SkillIQ>> skillIq;

    public LeadersViewModel(@NonNull Application application) {
        super(application);
        mLeadersRepository = new LeaderRepo();
    }

    public LiveData<List<LearnerHours>> getLearningLeaders() {
        learnerHours = mLeadersRepository.getLearnerLeaders();
        return learnerHours;
    }

    public LiveData<List<SkillIQ>> getSkillLeaders() {
        skillIq = mLeadersRepository.getSkillLeaders();
        return skillIq;
    }

}