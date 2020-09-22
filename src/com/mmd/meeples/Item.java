package com.mmd.meeples;

public enum Item {
    // basic items
    Sword("Bladed melee weapon intended for cutting."),
    Food("Material consisting of protein, carbohydrate, and fat."),
    Milk("Opaque white fluid rich in fat and protein."),
    Shield("Broad piece of metal or another suitable material."),
    Medicine("A compound used for the treatment of disease."),
    Gas_mask("Covers face as a defense against poisonous gas"),
    //upgraded items
    Space_stone("Represents the element of space."),
    Reality_stone("RepresentS the fabric of reality."),
    Power_stone("Weapon for granting a person with great, cosmic power."),
    Mind_stone("governs over the fabric of mind."),
    Time_stone("It has the ability to manipulate time."),
    Soul_stone("A soul for a soul.");

    private String description;

    Item(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}