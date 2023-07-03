from Organizm import Organizm
from abc import ABC, abstractmethod
from random import randrange


class Roslina(Organizm, ABC):
    def kolizja(self):
        pass

    def akcja(self):
        prawdopodobienstwo = randrange(10)
        #prawdopodobienstwo = 0
        if prawdopodobienstwo == 0:
            for i in range(10):
                x = randrange(self.moj.x)
                y = randrange(self.moj.y)
                if self.moj.tab[y][x] == ' ':
                    self.moj.organizmy.append(self.generator(x, y))
                    self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " rozmnozyl sie na x=" + str(
                        x) + " y=" + str(y) + '\n'
                    break
