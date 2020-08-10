package com.example.app.bbs.unit.controller

import com.example.app.bbs.app.controller.ArticleController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

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

    @Test
    fun getArticleListTest() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/")
        )
            .andExpect(status().isOk)
            .andExpect(model().attributeExists("articles"))
            .andExpect(view().name("index"))
    }
}
