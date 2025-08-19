package com.litealura.literalura.repository;

import com.litealura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro,Long> {
}
