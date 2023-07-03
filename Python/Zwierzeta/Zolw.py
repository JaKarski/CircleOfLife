from Zwierze import Zwierze


class Zolw(Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 2
        self.inicjatywa = 1
        self.symbol = 'Z'
        self.nazwa = "zolw"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Zolw(x, y, self.moj)
    
    def akcja(self):
        if self.wiek % 4 == 0:
            super(Zolw, self).akcja()

    def obrona(self, atakujacy):
        if atakujacy.sila < 5:
            self.moj.komentarz = self.moj.komentarz + "Zolw odbil atak "+ atakujacy.nazwa + '\n'
            return True
        else:
            return False
