package com.springframework.services;

import com.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

class ImageServiceImplTest {

    @Mock
    RecipeRepository testRecipeRepository;
    ImageService imageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        imageService = new ImageServiceImpl(testRecipeRepository);
    }

    @Test
    void saveImageFile() {

        Long id = 1L;

     //Todo: Impletment tests.

    }
}