from Roslina import Roslina


class Mlecz(Roslina):
    def __init__(self, x, y, moj):
        self.sila = 0
        self.inicjatywa = 0
        self.symbol = 'm'
        self.nazwa = "mlecz"
        self.wiek = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Mlecz(x, y, self.moj)

    def akcja(self):
        for i in range(3):
            super(Mlecz, self).akcja()
            self.moj.uzupelnij_tablice()
