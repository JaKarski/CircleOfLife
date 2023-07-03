from Zwierze import Zwierze

class Wilk (Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 9
        self.inicjatywa = 5
        self.symbol = 'W'
        self.nazwa = "wilk"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Wilk(x, y, self.moj)