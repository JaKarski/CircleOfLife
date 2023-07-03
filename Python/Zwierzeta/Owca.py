from Zwierze import Zwierze


class Owca(Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 4
        self.inicjatywa = 4
        self.symbol = 'O'
        self.nazwa = "owca"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Owca(x, y, self.moj)
