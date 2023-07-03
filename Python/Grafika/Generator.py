import PySimpleGUI as sg
from Swiat import Swiat


class NoweZwierze:
    def __init__(self, x, swiat):
        zwierzeta = ['wilk', 'owca', 'lis', 'zolw', 'antylopa', 'cyber-owca', 'trawa', 'mlecz', 'guarana', 'wilcze jagody', 'barszcz sosnowskiego']
        self.layout = [
            [sg.Text("Wybierz organizm do dodania: "), sg.Listbox(zwierzeta, size=(10, 10), key='-LIST-')],
            [sg.Button('Wybierz', key='-BUTTON-')]
        ]
        self.window = sg.Window('EcoSystem', self.layout)

        while True:
            event, values = self.window.read()
            if event == '-BUTTON-':
                print(values["-LIST-"])
                swiat.dodaj_organizm(values["-LIST-"], x % swiat.x, int((x - x % swiat.x) / swiat.x))
                break
            elif event == sg.WIN_CLOSED:
                break

        self.window.close()
