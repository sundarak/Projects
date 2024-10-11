

## Introduction

I designed and implemented a text-based, directional adventure video game that can be played in the console. The player will explore a two-dimensional, gridded map in search of treasures. The player will navigate through the world by entering keyword inputs such as "go north" or "go east" into the console. Each input will return a message based on what the player chose to do and their current surroundings. Some locations in the map will have "chests" containing items; the player can "open" a chest and take the items inside. The goal of the game is to find all the treasure in the map.

Text-based adventure games were first popularized in the late 1970's and early 1980's. Zork, [which you can read about here](https://en.wikipedia.org/wiki/Zork) [or play here](https://classicreload.com/zork-i.html), is a classic example of a text-based adventure game like the one we will be creating for this assignment.

The environment that the player will navigate through is two-dimensional, so let's assume a 2D, integer Cartesian coordinate system. This means the player's current position on the map can be modeled by two integers representing their `x` and `y` location. The player should be able to move north (i.e. in the positive-`y` direction), south (i.e. in the negative-`y` direction), east (i.e. in the positive-`x` direction), and west (i.e. in the negative-`x` direction) through the environment.

To make things more intersting, the game is basically in a virtual, text based map of Chapel Hill!

