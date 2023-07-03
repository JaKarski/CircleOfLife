from Grafika.Generator import NoweZwierze
from Grafika.Wymiary import Wymiary
from Roslina import Roslina
from Rosliny.Barszcz import Barszcz
from Rosliny.Guarana import Guarana
from Rosliny.Jagody import Jagody
from Rosliny.Mlecz import Mlecz
from Rosliny.Trawa import Trawa
from Swiat import Swiat
import PySimpleGUI as sg

from Zwierze import Zwierze
from Zwierzeta.Antylopa import Antylopa
from Zwierzeta.Cyber import CyberOwca
from Zwierzeta.Czlowiek import Czlowiek
from Zwierzeta.Lis import Lis
from Zwierzeta.Owca import Owca
from Zwierzeta.Wilk import Wilk
from Zwierzeta.Zolw import Zolw


class Manager:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.nowa_plansza()
        self.window = sg.Window('EcoSystem', self.layout, return_keyboard_events=True)

        while True:
            event, values = self.window.read()
            if event == 's':
                self.czas_na_ture(4)
            elif event == 'Left:37':
                self.czas_na_ture(1)
            elif event == 'Right:39':
                self.czas_na_ture(0)
            elif event == 'Up:38':
                self.czas_na_ture(2)
            elif event == 'Down:40':
                self.czas_na_ture(3)
            elif event == sg.WIN_CLOSED:
                break
            elif event == '-NOWA-':
                self.window.close()
                W = Wymiary()
                self.x = W.x
                self.y = W.y
                self.nowa_plansza()
                self.window = sg.Window('EcoSystem', self.layout, return_keyboard_events=True)
            elif event == '-ZAPISZ-':
                self.zapis()
            elif event == '-WCZYTAJ-':
                self.wczytaj()
                self.window = sg.Window('EcoSystem', self.layout_z, return_keyboard_events=True)
            if not isinstance(event, str):
                if 0 <= event <= self.x * self.y - 1:
                    NoweZwierze(event, self.S1)
                    self.aktualizuj_przyciski()
                    self.layout = [[sg.Button("Nowa Gra", key='-NOWA-'), sg.Button("Zapisz", key='-ZAPISZ-'),
                                    sg.Button("Wczytaj", key='-WCZYTAJ-')],
                                   self.przyciski,
                                   [sg.Text("**************************Wydarzenia**************************\n"
                                            + str(self.S1.komentarz) +
                                            "\n"
                                            "**************************Wydarzenia**************************")]]
                    self.window.close()
                    self.window = sg.Window('EcoSystem', self.layout, return_keyboard_events=True)
        self.window.close()

    def aktualizuj_przyciski(self):
        for j in range(self.y):
            for i in range(self.x):
                if self.S1.tab[i][j] == ' ':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='white',
                                         disabled=False)
                elif self.S1.tab[i][j] == 'C':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='red',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'W':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='brown',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'O':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='gray',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'L':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='orange',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'Z':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='green',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'A':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='purple',
                                         disabled=True)
                elif self.S1.tab[i][j] == '#':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='yellow',
                                         disabled=True)
                elif self.S1.tab[i][j] == 't':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j,
                                         button_color='yellow green',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'm':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='white',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'g':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='magenta4',
                                         disabled=True)
                elif self.S1.tab[i][j] == '*':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='black',
                                         disabled=True)
                elif self.S1.tab[i][j] == 'b':
                    przycisk = sg.Button(self.S1.tab[i][j], size=(2, 1), key=i * self.x + j, button_color='turquoise1',
                                         disabled=True)
                self.przyciski[i][j] = przycisk

    def czas_na_ture(self, ruch):
        self.S1.wykonaj_Ture(ruch)
        self.aktualizuj_przyciski()
        self.layout = [[sg.Button("Nowa Gra", key='-NOWA-'), sg.Button("Zapisz", key='-ZAPISZ-'),
                        sg.Button("Wczytaj", key='-WCZYTAJ-')],
                       self.przyciski, [sg.Text("**************************Wydarzenia**************************\n"
                                                + str(self.S1.komentarz) +
                                                "\n"
                                                "**************************Wydarzenia**************************")]]
        self.window.close()
        self.window = sg.Window('EcoSystem', self.layout, return_keyboard_events=True)

    def nowa_plansza(self):
        self.S1 = Swiat(self.x, self.y)
        self.przyciski = [[sg.Button(' ') for col in range(self.y)] for row in range(self.x)]
        self.aktualizuj_przyciski()
        self.layout = [[sg.Button("Nowa Gra", key='-NOWA-'), sg.Button("Zapisz", key='-ZAPISZ-'),
                        sg.Button("Wczytaj", key='-WCZYTAJ-')],
                       self.przyciski, [sg.Text("**************************Wydarzenia**************************\n"
                                                + str(self.S1.komentarz) +
                                                "\n\n"
                                                "**************************Wydarzenia**************************")]]

    def zapis(self):
        plik = open("Zapis", 'w')
        plik.write(str(self.x) + '\n')
        plik.write(str(self.y) + '\n')
        plik.write(str(len(self.S1.organizmy)) + '\n')
        for organizm in self.S1.organizmy:
            if isinstance(organizm, Czlowiek):
                plik.write(organizm.nazwa + '\n')
                plik.write(str(organizm.x) + '\n')
                plik.write(str(organizm.y) + '\n')
                plik.write(str(organizm.sila) + '\n')
                plik.write(str(organizm.wiek) + '\n')
                plik.write(str(organizm.special) + '\n')
                plik.write(str(organizm.wait) + '\n')
                plik.write(str(organizm.special_on) + '\n')
            elif isinstance(organizm, Zwierze):
                plik.write(organizm.nazwa + '\n')
                plik.write(str(organizm.x) + '\n')
                plik.write(str(organizm.y) + '\n')
                plik.write(str(organizm.sila) + '\n')
                plik.write(str(organizm.wiek) + '\n')
                plik.write(str(organizm.poRozmnozeniu) + '\n')
            elif isinstance(organizm, Roslina):
                plik.write(organizm.nazwa + '\n')
                plik.write(str(organizm.x) + '\n')
                plik.write(str(organizm.y) + '\n')
                plik.write(str(organizm.wiek) + '\n')
        plik.close()

    def wczytaj(self):
        plik = open("Zapis", 'r')

        x = plik.readline()
        y = plik.readline()
        ile = plik.readline()

        self.x = int(x)
        self.y = int(y)
        self.S1 = Swiat(self.x, self.y)
        self.przyciski = [[sg.Button(' ') for col in range(self.y)] for row in range(self.x)]
        self.S1.organizmy.clear()

        for i in range(int(ile)):
            organizm = plik.readline()
            if organizm == "czlowiek\n":
                self.czlowiek(plik)
            elif organizm == "wilk\n" or organizm == "owca\n" or organizm == "lis\n" or organizm == "zolw\n" or organizm == "antylopa\n" or organizm == "cyber-owca\n":
                self.zwierze(plik, organizm)
            elif organizm == 'trawa\n' or organizm == 'mlecz\n' or organizm == 'guarana\n' or organizm == 'wilcze jagody\n' or organizm == 'barszcz sosnowskiego\n':
                self.roslina(plik, organizm)

        self.S1.uzupelnij_tablice()
        self.aktualizuj_przyciski()
        self.layout.clear()
        self.layout_z = [[sg.Button("Nowa Gra", key='-NOWA-'), sg.Button("Zapisz", key='-ZAPISZ-'),
                          sg.Button("Wczytaj", key='-WCZYTAJ-')],
                         self.przyciski]
        self.window.close()
        plik.close()

    def czlowiek(self, plik):
        x1 = plik.readline()
        y1 = plik.readline()
        sila1 = plik.readline()
        wiek1 = plik.readline()
        special1 = plik.readline()
        wait1 = plik.readline()
        special_on1 = plik.readline()
        czlowiek1 = Czlowiek(int(x1), int(y1), self.S1)
        czlowiek1.sila = int(sila1)
        czlowiek1.wiek = int(wiek1)
        czlowiek1.special = int(special1)
        czlowiek1.wait = int(wait1)
        if special_on1 == 'False\n':
            czlowiek1.special_on = False
        else:
            czlowiek1.special_on = True
        self.S1.organizmy.append(czlowiek1)

    def roslina(self, plik, organizm):
        x1 = plik.readline()
        y1 = plik.readline()
        wiek1 = plik.readline()
        if organizm == 'trawa\n':
            W = Trawa(int(x1), int(y1), self.S1)
        elif organizm == 'mlecz\n':
            W = Mlecz(int(x1), int(y1), self.S1)
        elif organizm == 'guarana\n':
            W = Guarana(int(x1), int(y1), self.S1)
        elif organizm == 'wilcze jagody\n':
            W = Jagody(int(x1), int(y1), self.S1)
        elif organizm == 'barszcz sosnowskiego\n':
            W = Barszcz(int(x1), int(y1), self.S1)
        W.wiek = int(wiek1)
        self.S1.organizmy.append(W)

    def zwierze(self, plik, organizm):
        x1 = plik.readline()
        y1 = plik.readline()
        sila1 = plik.readline()
        wiek1 = plik.readline()
        porozmn1 = plik.readline()
        if organizm == 'wilk\n':
            W = Wilk(int(x1), int(y1), self.S1)
        elif organizm == 'owca\n':
            W = Owca(int(x1), int(y1), self.S1)
        elif organizm == 'lis\n':
            W = Lis(int(x1), int(y1), self.S1)
        elif organizm == 'zolw\n':
            W = Zolw(int(x1), int(y1), self.S1)
        elif organizm == 'antylopa\n':
            W = Antylopa(int(x1), int(y1), self.S1)
        elif organizm == 'cyber-owca\n':
            W = CyberOwca(int(x1), int(y1), self.S1)
        W.sila = int(sila1)
        W.wiek = int(wiek1)
        W.poRozmnozeniu = int(porozmn1)
        self.S1.organizmy.append(W)
