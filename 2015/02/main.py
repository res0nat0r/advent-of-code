#!/usr/bin/env python

# The elves are running low on wrapping paper, and so they need to submit an
# order for more. They have a list of the dimensions (length l, width w, and height h)
# and only want to order exactly as much as they need.

# Fortunately, every present is a box (a perfect right rectangular prism), which
# makes calculating the required wrapping paper for each gift a little easier:
# find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves
# also need a little extra paper for each present: the area of the smallest
# side.

# For example:

# A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet
# of wrapping paper plus 6 square feet of slack, for a total of 58 square
# feet.

# A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42
# square feet of wrapping paper plus 1 square foot of slack, for a total of
# 43 square feet.

# All numbers in the elves' list are in feet. How many total
# square feet of wrapping paper should they order?


def surface_area(l: int, w: int, h: int) -> int:
    return (2 * l * w) + (2 * w * h) + (2 * h * l)


def extra(l: int, w: int, h: int) -> int:
    return min([l * w, w * h, h * l])


def total(l: int, w: int, h: int) -> int:
    return surface_area(l, w, h) + extra(l, w, h)


def parse(line: str) -> tuple:
    return tuple(map(int, line.strip().split("x")))


def ribbon_wrap(l: int, w: int, h: int) -> int:
    return 2 * (l + w + h - max(l, w, h))


def ribbon_bow(l: int, w: int, h: int) -> int:
    return l * w * h


def ribbon_total(l: int, w: int, h: int) -> int:
    return ribbon_wrap(l, w, h) + ribbon_bow(l, w, h)


def part1():
    with open("data/input.txt", "r") as f:
        sum = 0

        for line in f:
            l, w, h = parse(line)
            sum += total(l, w, h)

        print(sum)


def part2():
    with open("data/input.txt", "r") as f:
        sum = 0

        for line in f:
            l, w, h = parse(line)
            sum += ribbon_total(l, w, h)

        print(sum)


part1()
part2()
