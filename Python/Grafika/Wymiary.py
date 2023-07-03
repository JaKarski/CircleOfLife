import PySimpleGUI as sg


class Wymiary:
    def __init__(self):
        self.layout = [
            [sg.Text("Symulator autorstwa: Kacper Karski, s186044, Informatyka Grupa 2\nW nastepnym kroku podaj wymiary planszy max 25")],
            [sg.Text("Podaj Wymiary planszy:"), sg.Input(key='-InputX-')],
            [sg.Button("Dalej", key='-BUTTON-')]
        ]
        self.window = sg.Window('EcoSystem', self.layout)

        while True:
            event, values = self.window.read()
            if event == '-BUTTON-':
                try:
                    int(values['-InputX-'])
                except ValueError:
                    self.x = 10
                    self.y = 10
                    break
                if 10 <= int(values['-InputX-']) <= 25:
                        self.x = int(values['-InputX-'])
                        self.y = int(values['-InputX-'])
                        break
                else:
                    self.x = 10
                    self.y = 10
                    break
        self.window.close()
