package com.example.app.bbs.unit.controller

import com.example.app.bbs.app.controller.ArticleController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
class ArticleControllerTests {
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var target: ArticleController

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build()
    }

    @Test
    fun registerArticleTest() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/")
                .param("name", "test_name")
                .param("title", "test_title")
                .param("contents", "test_contents")
                .param("articleKey", "test_article_key")
        )
            .andExpect(status().isOk)
            .andExpect(content().string("Saved"))
    }
}
