package com.example.unittest

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class RegisterTest {

    lateinit var register: Register
    @Before
    fun setUp() {
        register = Register()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun existingUsername(){
        val user= "Bahram"
        val result = register.validateRegistrationInput(user,"1234","1234")
        assertEquals("usernameexist", result,false)
    }

    @Test
    fun usernameEmpty(){
        val user = ""
        val result = register.validateRegistrationInput(user,"1234","1234")
        assertEquals("oke",result,false)
    }

    @Test
    fun confirmedPass() {
        val result = register.validateRegistrationInput(
            "Ariya",
            "12345",
            "12345"
        )
        assertEquals("oke",result,true)
    }

    @Test
    fun passwordEmpty_false(){
        val result = register.validateRegistrationInput("farhan","","12345")
        assertEquals("password empty", result, false)
    }

    @Test
    fun passwordKurangDari(){
        val result = register.validateRegistrationInput("zain","1","1")
        assertEquals("password kurang", result,false)
    }
    @Test
    fun passwordLebihDari(){
        val result = register.validateRegistrationInput("zain","1234567891011","1234567891011")
        assertEquals("password kurang", result,false)
    }

}