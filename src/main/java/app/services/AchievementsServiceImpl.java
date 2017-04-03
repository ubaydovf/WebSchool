package app.services;

import app.interfaces.AchievementsService;
import app.models.Achievements;
import app.repositories.AchievementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementsServiceImpl implements AchievementsService {

    @Autowired
    private AchievementsRepository achievementsRepository;

    @Override
    public Achievements addAchievements(Achievements achievement) {
        return achievementsRepository.save(achievement);
    }

    @Override
    public Achievements getAchievementsById(Long id) {
        return achievementsRepository.findOne(id);
    }

    @Override
    public List<Achievements> getAchievements() {
        return achievementsRepository.findAll();
    }

    @Override
    public Achievements updateAchievements(Achievements achievements) {
        return achievementsRepository.save(achievements);
    }

    @Override
    public void deleteAchievementsById(Long id) {
        achievementsRepository.delete(id);
    }
}
