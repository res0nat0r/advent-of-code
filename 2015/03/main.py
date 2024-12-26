#!/usr/bin/env python

# Santa is delivering presents to an infinite two-dimensional grid of houses.

# He begins by delivering a present to the house at his starting location, and
# then an elf at the North Pole calls him via radio and tells him where to move
# next. Moves are always exactly one house to the north (^), south (v), east (>),
# or west (<). After each move, he delivers another present to the house at his
# new location.

# However, the elf back at the north pole has had a little too much eggnog, and so
# his directions are a little off, and Santa ends up visiting some houses more
# than once. How many houses receive at least one present?

stops = [0]
stops = [[stops for _ in range(8192)] for _ in range(8192)]
total_stops = 0

x = 0
y = 0

with open("data/input.txt") as f:
    stops[x][y] = 1

    for i in f:
        match i:
            case "^":
                y += 1
                stops[x][y] += 1
            case ">":
                x += 1
                stops[x][y] += 1
            case "v":
                y -= 1
                stops[x][y] += 1
            case "<":
                x -= 1
                stops[x][y] += 1

for x in range(8192):
    for y in range(8192):
        if stops[x][y] >= 1:
            total_stops +=1

print(total_stops)