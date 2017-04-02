package app.services;

import app.interfaces.ClazzService;
import app.models.Clazz;
import app.repositories.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService{

    @Autowired
    private ClazzRepository clazzRepository;

    @Override
    public Clazz addClazz(Clazz clazz) {

        return clazzRepository.save(clazz);
    }

    @Override
    public Clazz getClazzById(Long id) {
        return clazzRepository.findOne(id);
    }

    @Override
    public List<Clazz> getClazzes() {
        return clazzRepository.findAll();
    }

    @Override
    public Clazz updateClazz(Clazz clazz) {
        return clazzRepository.save(clazz);
    }

    @Override
    public void deleteClazzById(Long id) {
        clazzRepository.delete(id);
    }

    @Override
    public List<Clazz> findAllByTeacherId(Long teacherId) {
        return clazzRepository.findAllByTeacherId(teacherId);
    }
}
