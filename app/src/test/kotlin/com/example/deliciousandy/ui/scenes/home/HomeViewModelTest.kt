package com.example.deliciousandy.ui.scenes.home

import com.example.deliciousandy.data.models.Recipe
import com.example.deliciousandy.data.repos.RecipeRepository
import io.github.hellocuriosity.forgeryList
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeViewModelTest {

    private val repository: RecipeRepository = mockk()

    // Instance of our SUT -> HomeViewModel
    private val viewModel: HomeViewModel = HomeViewModel(repository = repository)

    @After
    fun teardown() {
        confirmVerified(repository)
    }

    @Test
    fun testLoadRecipes() {
        val recipes : List<Recipe> by forgeryList()

        // Mock repository response
        every { repository.loadRecipes() } returns recipes

        val result = viewModel.loadRecipes()
        assertEquals(recipes, result)

        verify { repository.loadRecipes() }
    }

    @Test
    fun testLoadRecipesEmptyList() {
        // Mock repository response
        every { repository.loadRecipes() } returns emptyList()

        val expected = emptyList<Recipe>()
        val result = viewModel.loadRecipes()
        assertEquals(expected, result)

        verify { repository.loadRecipes() }
    }
}
