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

    if (targetHp + potionStrength > targetMaxHp) {
        exHP = targetMaxHp - exHP
    }

    return println("$targetName boit une potion et récupère $potionStrength PV.")
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
    //pas fini, fonctionne pas encore bien
}