package dao;

import entity.RegistrationPeriod;
import models.RegistrationPeriodModel;
import models.UserModel;

public interface IRegistrationPeriodDAO {
    void create(RegistrationPeriodModel registrationPeriodModel);
    RegistrationPeriodModel get(int Id);
    void update(RegistrationPeriod registrationPeriod);
    void delete(int Id);
}
