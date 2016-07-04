class Parent():
    def __init__(self, last_name, eye_color):
        # print("Parent Constructor Called")
        self.last_name = last_name
        self.eye_color = eye_color

    def show_info(self):
        print("Last name: " + self.last_name)
        print("Eye color: " + self.eye_color)

class Child(Parent):
    def __init__(self, last_name, eye_color, age):
        # print("Child Constructor Called")
        Parent.__init__(self, last_name, eye_color)
        self.age = age

    def show_info(self):
        print("Last name: " + self.last_name)
        print("Eye color: " + self.eye_color)
        print("Age: " + str(self.age))

k_kwon = Child("Kwon", "Brown", 30)
k_kwon.show_info()
