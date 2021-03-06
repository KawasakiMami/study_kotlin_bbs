package com.example.app.bbs.app.controller

import com.example.app.bbs.domain.entity.Article
import com.example.app.bbs.domain.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import com.example.app.bbs.app.request.ArticleRequest
import org.springframework.ui.Model

@Controller
class ArticleController {
    @Autowired
    lateinit var articleRepository: ArticleRepository

    @PostMapping("/")
    fun registerArticle(@ModelAttribute articleRequest: ArticleRequest): String {
        articleRepository.save(
            Article(
                articleRequest.id,
                articleRequest.name,
                articleRequest.title,
                articleRequest.contents,
                articleRequest.articleKey
            )
        )

        return "redirect:/"
    }

    @GetMapping("/")
    fun getArticleList(model: Model) : String{
        model.addAttribute("articles", articleRepository.findAll())

        return "index"
    }

}
