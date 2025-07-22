package com.project.brothers_bakery.domain

import org.springframework.stereotype.Component

@Component
class CpfValidator {

    fun validate(cpf: String): Boolean {
        val cleanCpf = clean(cpf)
        if (isInvalidLength(cleanCpf)) return false
        if (allDigitsTheSame(cleanCpf)) return false
        val dg1 = calculateDigit(cleanCpf, 10)
        val dg2 = calculateDigit(cleanCpf, 11)
        val checkDigit = extractDigit(cleanCpf)
        val calculatedDigit = "$dg1$dg2"
        return checkDigit == calculatedDigit
    }

    fun clean(cpf: String): String {
        return cpf.replace(Regex("\\D"), "")
    }

    fun isInvalidLength(cpf: String): Boolean {
        return cpf.length != 11
    }

    fun allDigitsTheSame(cpf: String): Boolean {
        return cpf.all { it == cpf[0] }
    }

    fun calculateDigit(cpf: String, factor: Int) : Int{
        var total = 0
        var mutableFactor = factor
        for (digit in cpf) {
            if (mutableFactor > 1) {
                total += digit.digitToInt() * mutableFactor--
            }
        }
        val rest = total%11
        return if (rest < 2) 0 else 11 - rest
    }

    fun extractDigit(cpf: String): String {
        return cpf.substring(cpf.length - 2, cpf.length)
    }
}