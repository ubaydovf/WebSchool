package app.interfaces;

import app.models.Achievement;

import java.util.List;

public interface AchievementService {

    Achievement addAchievement(Achievement achievement);

    Achievement getAchievementById(Long id);

    List<Achievement> getAchievements();

    Achievement updateAchievement(Achievement achievement);

    void deleteAchievementById(Long id);

}
