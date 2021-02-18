package com.nash.Jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRepository extends JpaRepository<Jwt, Long> {
}