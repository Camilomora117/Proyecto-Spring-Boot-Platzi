package com.fundamentosplatzi.springboot.proyectrospring.repository;

import com.fundamentosplatzi.springboot.proyectrospring.dto.UserDto;
import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findMyUserByEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByNameAndEmail(String name, String email);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameLikeOrderByIdAsc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("Select new com.fundamentosplatzi.springboot.proyectrospring.dto.UserDto(u.id, u.name, u.birthDate)" +
            " From User u " +
            " Where u.birthDate=:parametroFecha AND u.email=:parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);

    List<User> findAll();

}
