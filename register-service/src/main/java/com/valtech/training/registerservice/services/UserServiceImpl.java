package com.valtech.training.registerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserVO saveOrUpdateUser(UserVO vo) {
        User user = vo.to();
        user = userRepo.save(user);
        return UserVO.from(user);
    }

    @Override
    public UserVO getUser(long id) {
        return UserVO.from(userRepo.getReferenceById(id));
    }

    @Override
    public List<UserVO> getAllUsers() {
        return userRepo.findAll().stream().map(UserVO::from).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> getKids() {
        return userRepo.findAll().stream()
                .filter(User::isKid)
                .map(UserVO::from)
                .collect(Collectors.toList());
    }

    @Override
    public UserVO updateUser(UserVO vo, long id) {
        User user = userRepo.getReferenceById(id);
        user = vo.to();
        user = userRepo.save(user);
        return UserVO.from(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
}
