package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.repo.UserRepository;

import java.util.*;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private  HashMap<Short, Integer> banksnotList; // key - номинал банкноты, value - количество купюр


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    public void withdraw(User user, Integer reqSum) {

        Integer sum = 0;

        HashMap<Integer, Integer> banknots = new HashMap<>();

        banknots.put(5000, 2);
        banknots.put(1000, 3);
        banknots.put(500, 17);
        banknots.put(100, 6);
        banknots.put(50, 54);
        banknots.put(10, 43);
        banknots.put(1, 14);

        Iterator<Map.Entry<Integer, Integer>> iterator = banknots.entrySet().iterator();

        int k=0;

        while (iterator.hasNext()) {

            int summ = 0;
            List<Integer> nominalValue = new ArrayList<>();
            List<Integer> quantity = new ArrayList<>();

            HashMap<Integer, Integer> selectBanknots = new HashMap<>();

            int nominal = iterator.next().getKey();
            // изначальный баланс купюр
            int initBalance = banknots.get(nominal);
            // текущий остаток купюр
            int ost = initBalance;
            // сначала выберем максимальные купюры
            if (reqSum>nominal){
                k++;
                if (initBalance!=0) {
                    ost = initBalance - 1; }
                else  {
                    if (ost == 0) {
                        // то больше ее не подбираем
                        iterator.remove(); }
                }
                nominalValue.add(nominal);
                quantity.add(1);
                sum = sum + nominal;
                if (sum == reqSum) {
                    break;
                }


            }

        }

        banknots.forEach((a,b) -> System.out.println("Номинал:" + a + " Кол-во: " + b));




    }

    public void deposite() {

    }

}
