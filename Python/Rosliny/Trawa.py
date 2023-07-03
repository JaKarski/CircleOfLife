from Roslina import Roslina


class Trawa(Roslina):
    def __init__(self, x, y, moj):
        self.sila = 0
        self.inicjatywa = 0
        self.symbol = 't'
        self.nazwa = "trawa"
        self.wiek = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Trawa(x, y, self.moj)
