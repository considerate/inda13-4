#Uppgift

Beräkna tidskomplexiteten i medelfall för sökning, insättning och borttagning i en

## osorterad vektor

**sökning** efter ett givet element, T(n) = d*i + c där d,c ∈ ℝ och i ∈ ℤ
Antag att det är lika stor sannolikhet för elementet att finnas på en given plats i vektorn vilket ger `i = n/2` i basfallet och tidskomplexiteten är T(n) = d*n/2 + c där d,c ∈ ℝ ⇔ T(n) ∈ Ο(n)

**insättning** av ett element på plats i, T(n) = d*(n-i)+c ∈ Ο(n) där c ∈ ℝ eftersom om i ≠ 0 så behöver alla element efter i flyttas ett steg i vektorn.

**borttagning** av ett element på plats i, T(n) = d*(n-i)+c ∈ Ο(n) där c ∈ ℝ i detta fall behöver elementen flyttas tillbaka efter borttagning.

## sorterad vektor

**sökning** efter element, `i = n/2` enligt ovan. I detta fall börjar vi med att titta på det mellersta elementet för att finna om det eftersökta elementet kommer före, efter eller om det stämde. 

Ifall det eftersökta elementet är mindre än platsen som inspekteras nu:
Dela den vänstra delen av vektorn i två och fortsätt med det nya värdet på mitten.

Ifall det är större än den inspekterade platsen:
Dela den högra den av vektorn i två delar och fortsätt

Ifall det är lika med den inspekterade platsen:
Avsluta med att det eftersökta elementet finns på den nu funna platsen.

Mästarsatsen ger: 
då T(n) = aT(n/b) + f(n) 

Om f(n) = Θ(n<sup>d</sup>), där d ≥ 0, så gäller
T(n) ∈ Θ(n<sup>d</sup>) om a < b<sup>d</sup>,
T(n) ∈ Θ(n<sup>d</sup>log n) om a = b<sup>d</sup>,
T(n) ∈ Θ(n<sup>log<sub>b</sub>a</sup>) om a > b<sup>d</sup>.

där a är antalet självrekursiva anrop, b är hur mycket informationsmängden delas med i nästa rekursion och f(n) är det konstanta arbete som utförs i varje rekursion.

a = 1 i detta fall.
b = 2.
f(n) ∈ Θ(1) ⇒ d = 0
b<sup>d</sup> = 2<sup>0</sup> = 1 ⇒ a = b<sup>d</sup>

T(n) ∈ Θ(n<sup>0</sup>log n) = Θ(log n)

**insättning** av ett element på plats i, T(n) = c ∈ Ο(1) där c ∈ ℝ

**borttagning** av ett element på plats i, T(n) = c ∈ Ο(1) där c ∈ ℝ

## osorterad enkellänkad lista

**sökning** vi får samma resultat som i fallet med den osorterade vektorn. T(n) ∈ Ο(n)
**insättning** I detta fall måste listan gås igenom för insättning. Insättningen kan i medelfallet antas ske lika på en godtycklig plats i listan. i är därför n/2. T(n) ∈ Ο(n)
**borttagning** Samma som ovan gäller.

## sorterad enkellänkad lista
För en sorterad enkellänkad lista gäller samma som för en osorterad.

## hashtabell (du kan anta att antalet element är lika med hashtabellens storlek).
**sökning** Ο(1), eftersom hashkoden kommer sannolikt generera ett index som är unikt till just detta element i medelfallet och då behöver endast det elementet undersökas.
**insättning** O(1).
**borttagning** O(1).