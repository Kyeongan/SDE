import turtle

def drawsquare():
    window = turtle.Screen()
    window.bgcolor("red")

    brad = turtle.Turtle()
    brad.shape("turtle")
    brad.color("yellow")
    brad.speed(2)

    for j in range(1, 37):
        for i in range(1,5):
            brad.forward(100)
            brad.right(90)
        brad.right(10)

    # drawcircle()

    window.exitonclick()

def drawcircle():
    angie = turtle.Turtle()
    angie.color("blue")
    angie.circle(100)

drawsquare()
