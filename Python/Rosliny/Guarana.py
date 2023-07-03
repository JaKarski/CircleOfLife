from Roslina import Roslina


class Guarana(Roslina):
    def __init__(self, x, y, moj):
        self.sila = 0
        self.inicjatywa = 0
        self.symbol = 'g'
        self.nazwa = "guarana"
        self.wiek = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Guarana(x, y, self.moj)

    def obrona(self, atakujacy):
        atakujacy.sila += 3
        self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zwiekszyl sile " + atakujacy.nazwa + '\n'
        self.czyZyje = False
        return False
