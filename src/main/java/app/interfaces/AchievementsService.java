package app.interfaces;

import app.models.Achievements;

import java.util.List;

public interface AchievementsService {

    Achievements addAchievements(Achievements achievements);

    Achievements getAchievementsById(Long id);

    List<Achievements> getAchievements();

    Achievements updateAchievements(Achievements achievements);

    void deleteAchievementsById(Long id);

}
