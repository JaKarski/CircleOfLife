from Zwierze import Zwierze

CZAS_OCZEKIWANIA = 5


class Czlowiek(Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 5
        self.inicjatywa = 4
        self.symbol = 'C'
        self.nazwa = "czlowiek"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True
        self.special = 0
        self.wait = 0
        self.special_on = False

    def akcja(self):
        if self.special_on and self.wait > CZAS_OCZEKIWANIA:
            self.moj.komentarz = self.moj.komentarz + "Umiejetnosc specjalna czlowieka wlaczona" + '\n'
            for organizm in self.moj.organizmy:
                if organizm.czyZyje:
                    if self.x - 1 <= organizm.x <= self.x + 1 and self.y - 1 <= organizm.y <= self.y + 1:
                        if organizm is not self:
                            self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zabil " + organizm.nazwa + " ktory byl w jego poblizu (umiejetnosc Calopalenia)" + '\n'
                            organizm.czyZyje = False

        kierunek = self.moj.ruchy
        if kierunek == 0:
            if 0 <= self.x < self.moj.x - 1:
                self.x += 1
                if self.czyKolizja():
                    self.kolizja(0)
        elif kierunek == 1:
            if 0 < self.x <= self.moj.x - 1:
                self.x -= 1
                if self.czyKolizja():
                    self.kolizja(1)
        elif kierunek == 2:
            if 0 < self.y <= self.moj.y - 1:
                self.y -= 1
                if self.czyKolizja():
                    self.kolizja(2)
        elif kierunek == 3:
            if 0 <= self.y < self.moj.y - 1:
                self.y += 1
                if self.czyKolizja():
                    self.kolizja(3)
        elif kierunek == 4:
            self.special_on = True

    def wiek_wzrasta(self):
        self.wiek += 1
        if self.special_on and self.wait > CZAS_OCZEKIWANIA:
            self.special += 1
            if self.special == CZAS_OCZEKIWANIA + 1:
                self.special = 0
                self.wait = 0
                self.special_on = False
        self.wait += 1

    def generator(self, x, y):
        pass