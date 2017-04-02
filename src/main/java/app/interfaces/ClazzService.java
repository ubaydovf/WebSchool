package app.interfaces;

import app.models.Clazz;

import java.util.List;

public interface ClazzService {

    Clazz addClazz(Clazz student);

    Clazz getClazzById(Long id);

    List<Clazz> getClazzes();

    Clazz updateClazz(Clazz clazz);

    void deleteClazzById(Long id);

    List<Clazz> findAllByTeacherId(Long teacherId);
}
