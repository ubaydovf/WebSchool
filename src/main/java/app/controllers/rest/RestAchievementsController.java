package app.controllers.rest;

import app.interfaces.AchievementService;
import app.interfaces.AchievementsService;
import app.models.Achievement;
import app.models.Achievements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestAchievementsController {

    @Autowired
    private AchievementsService achievementsService;
    @Autowired
    private AchievementService achievementService;

    /** -------------------------  /achievement     ----------------------- */

    @RequestMapping(value = "/achievement", method = RequestMethod.GET)
    public ResponseEntity<List<Achievement>> getAchievementList() {

        List<Achievement> achievements = achievementService.getAchievements();
        if (achievements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }

    /* Get Achievement by ID */
    @RequestMapping(value = "/achievement/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAchievement(@PathVariable Long id) {
        Achievement achievement = achievementService.getAchievementById(id);
        if (achievement != null) {
            return new ResponseEntity<>(achievement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Create an Achievement */
    @RequestMapping(value = "/achievement", method = RequestMethod.POST)
    public ResponseEntity<?> createAchievement(@RequestBody Achievement achievement) {
        if (achievement != null) {
            return new ResponseEntity<>(achievementService.addAchievement(achievement), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Edit an Achievement by ID */
    @RequestMapping(value = "/achievement/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAchievement(@RequestBody Achievement achievement) {
        if (achievement != null) {
            return new ResponseEntity<>(achievementService.updateAchievement(achievement), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Delete an Achievement by ID */
    @RequestMapping(value = "/achievement/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAchievement(@PathVariable Long id) {
        achievementService.deleteAchievementById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /** -------------------------  /achievements     ----------------------- */

    /* Get all Achievements */
    @RequestMapping(value = "/achievements", method = RequestMethod.GET)
    public ResponseEntity<List<Achievements>> getAchievements() {

        List<Achievements> achievements = achievementsService.getAchievements();
        if (achievements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }

    /* Get Achievement by ID */
    @RequestMapping(value = "/achievements/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAchievements(@PathVariable Long id) {
        Achievements achievements = achievementsService.getAchievementsById(id);
        if (achievements != null) {
            return new ResponseEntity<>(achievements, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Create an Achievement */
    @RequestMapping(value = "/achievements", method = RequestMethod.POST)
    public ResponseEntity<?> createAchievements() {
        Achievements achievements = new Achievements();
            return new ResponseEntity<>(achievementsService.addAchievements(achievements), HttpStatus.OK);
    }

    /* Edit an Achievement by ID */
    @RequestMapping(value = "/achievements/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAchievements(@RequestBody Achievements achievement) {
        if (achievement != null) {
            return new ResponseEntity<>(achievementsService.updateAchievements(achievement), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Delete an Achievement by ID */
    @RequestMapping(value = "/achievements/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAchievements(@PathVariable Long id) {
        achievementsService.deleteAchievementsById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /* ------------------------------------------------------------------------------------- */

    /* Gey an Achievement from Achievements */
    @RequestMapping(value = "/achievements/{id}/achievement", method = RequestMethod.GET)
    public ResponseEntity<?> getAchievementById(@PathVariable Long id) {
        Achievements achievements = achievementsService.getAchievementsById(id);
        if (achievements != null) {
            if (!achievements.getAchievementList().isEmpty()) {
                return new ResponseEntity<>(achievements.getAchievementList(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Get an Achievement from Achievements by Achievement id*/
    @RequestMapping(value = "/achievements/{id}/achievement/{aId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAchievementInAchievementsById(@PathVariable Long id, @PathVariable Long aId) {
        Achievements achievements = achievementsService.getAchievementsById(id);
        if (achievements != null) {
            Map<Long, Achievement> map = achievements.getAchievementList();
            if (map.get(aId) != null) {
                return new ResponseEntity<>(map.get(aId), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Put an Achievement from Achievements */
    @RequestMapping(value = "/achievements/{id}/achievement/{aId}", method = RequestMethod.PUT)
    public ResponseEntity<?> putAchievementInAchievements(@PathVariable Long id, @PathVariable Long aId) {
        Achievements achievements = achievementsService.getAchievementsById(id);
        Achievement achievement = achievementService.getAchievementById(aId);
        if (achievements != null && achievement != null) {
            achievements.addAchievement(achievement);
            achievementsService.updateAchievements(achievements);
                return new ResponseEntity<>(achievements.getAchievementList(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Delete an Achievement from Achievements by ID */
    @RequestMapping(value = "/achievements/{id}/achievement/{aId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAchievementFromAchievements(@PathVariable Long id, @PathVariable Long aId) {
        Achievements achievements = achievementsService.getAchievementsById(id);
        Achievement achievement = achievementService.getAchievementById(aId);
        if (achievements != null && achievement != null) {
            achievements.removeAchievement(achievement);
            achievementsService.updateAchievements(achievements);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}