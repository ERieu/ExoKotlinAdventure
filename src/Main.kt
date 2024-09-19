import kotlin.enums.enumEntries

fun calculDefenseTotal(def: Int, armorType: Int, armorRarity: Int): Int {
    return def + armorType + armorRarity
}

fun lanceDes(nbDes: Int, nbFaces: Int): Int {
    return (nbDes..nbFaces*nbDes).random()
}

fun calculDegatArme(nbDes: Int, nbFaces: Int, weaponRarityBonus: Int, critTreshold: Int, critMultiplier: Int): Int {
    var dmg = lanceDes(nbDes, nbFaces)

    if (dmg >= critTreshold)
        dmg * critMultiplier

    dmg + weaponRarityBonus

    if (dmg < 0)
        return 0
    else
        return dmg
}

fun attaque(defenderHp: Int, weaponDmg: Int, defTotal: Int, attackerName: String, defenderName: String) {
    var dmg = weaponDmg - defTotal
    var hp = defenderHp

    if (dmg < 0) dmg = 0

//    if (hp < dmg) hp -= hp
//    else hp -= dmg

    /* ou pour afficher le nombre de dégats qui ne dépasse pas les pv restants comme dans l'énoncé
    if (hp < dmg) {
        dmg = hp
        hp -= dmg
    }
    else hp -= dmg
    */

    return println("$attackerName attaque $defenderName pour $dmg point(s) de dégats, $defenderName a $hp point(s) de vie.")
}

fun boirePotion(targetName: String, targetHp: Int, targetMaxHp: Int, potionStrength: Int) {
    var exHP = targetHp
    var hp = targetHp + potionStrength

    if (hp > targetMaxHp)
        hp = targetMaxHp

    val newHP = hp - exHP

    return println("$targetName boit une potion et récupère $newHP PV.")
}

fun bouleDeFeu(casterName: String, targetName: String, casterAtk: Int, targetDefTotal: Int, targetHp: Int) {
    var hp = targetHp
    var spellDmg = lanceDes(casterAtk/3, 6)

    if (spellDmg < 0) spellDmg = 0

    spellDmg - targetDefTotal

    if (spellDmg > hp) hp = 0
    else hp -= spellDmg

    println("$casterName lance une boule de feu et inflige $spellDmg point(s) de dégâts à $targetName, $targetName a $hp PV restant.")
}

fun missileMagique(casterName: String, targetName: String, casterAtk: Int, targetDefTotal: Int, targetHp: Int) {
    var missileDmg = 0
    val nbMissile = casterAtk / 2
    var targetHp = targetHp

    for (i in 0..nbMissile) {
        if (targetHp <= 0) {
            println("Les PV de $targetName sont tombés à 0.")
            break
        }
        missileDmg = lanceDes(1, 6) - targetDefTotal
        targetHp -= missileDmg
        println("$casterName lance un missile magique et inflige $missileDmg point(s) de dégâts à $targetName.")
        println("$targetName a $targetHp PV restant.")
    }
}

fun main() {
    //Exo 1
    //println(calculDefenseTotal(3, 2, 1))

    //Exo 2
    //println(lanceDes(1, 6))
    //println(lanceDes(2, 5))
    //println(lanceDes(4, 20))

    //Exo 3
    //println(calculDegatArme(1, 6, 2, 6, 2))
    //println(calculDegatArme(1, 8, 3, 5, 3))
    //println(calculDegatArme(2, 4, 2, 10, 2))

    //Exo 4
    //println(attaque(15, 4, 3, "Evan", "pnjRandomN°23"))
    //println(attaque(5, 9, 2, "Evan", "pnjRandomN°5"))

    //Exo 5
    //println(boirePotion("Evan", 8, 20, 6))

    //Exo 6
    //println(bouleDeFeu("Evan", "pnjRandomN°99", 5, 3, 10))

    //Exo 7 (ne fonctionne pas)
    //println(missileMagique("Evan", "pnjRandomN°12", 12, 5, 20))
}