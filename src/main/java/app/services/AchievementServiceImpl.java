package app.services;

import app.interfaces.AchievementService;
import app.models.Achievement;
import app.repositories.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Override
    public Achievement addAchievement(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public Achievement getAchievementById(Long id) {
        return achievementRepository.findOne(id);
    }

    @Override
    public List<Achievement> getAchievements() {
        return achievementRepository.findAll();
    }

    @Override
    public Achievement updateAchievement(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public void deleteAchievementById(Long id) {
        achievementRepository.delete(id);
    }
}
