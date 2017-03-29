from random import choice
class NodoMatriz(object):
	def __init__(self):
		super(NodoMatriz, self).__init__()
		self.usuario=""
		self.contrasena=""
		self.NombreCompleto=""
		self.arbol=ArbolAVL()
		self.lista=ListaSimple()
		self.Nombre=""
		self.Correo=""
		self.Empresa=""
		self.Dep=""
		self.Derecha=None
		self.Izquierda=None
		self.Arriba=None
		self.Abajo=None
		self.ArribaP=None
		self.AbajoP=None

class Matriz(object):
	def __init__(self):
		super(Matriz, self).__init__()
		self.Inicio=NodoMatriz()
		self.Inicio.Nombre="0"
		self.Inicio.Correo="0"
	def insertar(self,Nombre,Empresa,Dep,contrasena,Completo):
		empresa=self.buscarempresa(Empresa)
		dep=self.buscarDep(Dep)
		nuevo=NodoMatriz()
		nuevo.Nombre=Nombre
		nuevo.contrasena=contrasena
		nuevo.NombreCompleto=Completo
		nuevo.Empresa=Empresa
		nuevo.Dep=Dep
		if empresa==None and dep==None:	
			self.caso1(nuevo,Empresa,Dep)
		elif empresa!=None and dep==None:				
			self.caso2(nuevo,empresa,Dep)
		elif empresa==None and dep!=None:
			self.caso3(nuevo,Empresa,dep)
		elif empresa!=None and dep!=None:			
			self.caso4(nuevo,empresa,dep)

	def buscarempresa(self,Valor):
		encontrado=False
		actual=self.Inicio
		while actual!=None and encontrado==False:
				if actual.Nombre!=Valor:
					actual=actual.Derecha
				else :					
					encontrado=True	
		return actual
	def buscarDep(self,Valor):
		encontrado=False
		actual=self.Inicio
		while actual!=None and encontrado==False:
				if actual.Nombre!=Valor:
					actual=actual.Abajo
				else :					
					encontrado=True
		return actual
	def buscarUser(self,usuario,empresa,departamento):
		encontrado=False
		actual=self.Inicio
		while actual!=None and encontrado==False:
				if actual.Nombre!=departamento:
					actual=actual.Abajo
				else :					
					encontrado=True
		if encontrado==False:
			return None
		encontrado=False
		while actual!=None and encontrado==False:
				actual2=actual
				while actual2:
					if actual2.Nombre==usuario and actual2.Empresa==empresa:
						return actual2
					actual2=actual2.AbajoP
				if actual.Nombre==usuario and actual.Empresa==empresa:
					return actual
				else:
					actual=actual.Derecha
		return None
	def buscar(self,Valor):
		encontrado=False
		actual=self.Inicio
		if len(Valor)>1:
			while actual!=None and encontrado==False:
				if actual.Nombre!=Valor:
					actual=actual.Derecha
				else :					
					encontrado=True					
		else :
			while actual!=None and encontrado==False:
				if actual.Nombre!=Valor:
					actual=actual.Abajo
				else :					
					encontrado=True
		return actual

	def caso1(self,anadir,Correo,Letra):
		correo=NodoMatriz()
		letra=NodoMatriz()
		correo.Nombre=Correo
		letra.Nombre=Letra
		#Anadiendo Correo no Existente
		if self.Inicio.Derecha==None:
			self.Inicio.Derecha=correo
			correo.Izquierda=self.Inicio
		else:	
			aux=self.Inicio
			while aux.Nombre<Correo and aux.Derecha!=None:	
				aux=aux.Derecha			
			if aux.Nombre<Correo:								
				aux.Derecha=correo
				correo.Izquierda=aux
			else :	
				aux.Izquierda.Derecha=correo
				correo.Izquierda=aux.Izquierda
				correo.Derecha=aux
				aux.Izquierda=correo
		#Anadiendo Letra no Existente
		if self.Inicio.Abajo==None:
			self.Inicio.Abajo=letra
			letra.Arriba=self.Inicio
		else:	
			aux=self.Inicio
			while aux.Nombre<Letra and aux.Abajo!=None:	
				aux=aux.Abajo			
			if aux.Nombre<Letra:								
				aux.Abajo=letra
				letra.Arriba=aux
			else :	
				aux.Arriba.Abajo=letra
				letra.Arriba=aux.Arriba
				letra.Abajo=aux
				aux.Arriba=letra
		#Anadiendo Nombre
		correo.Abajo=anadir
		letra.Derecha=anadir
		anadir.Izquierda=letra
		anadir.Arriba=correo

	def caso2(self,anadir,correo,Letra):		
		letra=NodoMatriz()
		letra.Nombre=Letra
		#Anadiendo Letra no Existente
		if self.Inicio.Abajo==None:
			self.Inicio.Abajo=letra
			letra.Arriba=self.Inicio
		else:	
			aux=self.Inicio
			while aux.Nombre<Letra and aux.Abajo!=None:	
				aux=aux.Abajo			
			if aux.Nombre<Letra:								
				aux.Abajo=letra
				letra.Arriba=aux
			else :	
				aux.Arriba.Abajo=letra
				letra.Arriba=aux.Arriba
				letra.Abajo=aux
				aux.Arriba=letra
			aux=self.Inicio
		#Anadiendo Nombre		
		letra.Derecha=anadir
		anadir.Izquierda=letra		
		#Anadiendo Nodo a Correo correspondiente
		aux=correo.Abajo
		while aux.Dep<Letra and aux.Abajo!=None:	
				aux=aux.Abajo		
		if aux.Dep<Letra:								
				aux.Abajo=anadir
				anadir.Arriba=aux
		else :	
				aux.Arriba.Abajo=anadir
				anadir.Arriba=aux.Arriba
				anadir.Abajo=aux
				aux.Arriba=anadir		

	def caso3(self,anadir,Correo,letra):		
		correo=NodoMatriz()	
		correo.Nombre=Correo	
		#Anadiendo Correo no Existente
		if self.Inicio.Derecha==None:
			self.Inicio.Derecha=correo
			correo.Izquierda=self.Inicio
		else:	
			aux=self.Inicio
			while aux.Nombre<Correo and aux.Derecha!=None:	
				aux=aux.Derecha			
			if aux.Nombre<Correo:								
				aux.Derecha=correo
				correo.Izquierda=aux
			else :	
				aux.Izquierda.Derecha=correo
				correo.Izquierda=aux.Izquierda
				correo.Derecha=aux
				aux.Izquierda=correo
		#Anadiendo Nombre		
		correo.Abajo=anadir		
		anadir.Arriba=correo	
		#Anadiendo Nodo a Letra correspondiente
		aux=letra.Derecha
		while aux.Empresa<Correo and aux.Derecha!=None:	
				aux=aux.Derecha		
		if aux.Empresa<Correo:								
				aux.Derecha=anadir
				anadir.Izquierda=aux
		else :	
				aux.Izquierda.Derecha=anadir
				anadir.Izquierda=aux.Izquierda
				anadir.Derecha=aux
				aux.Izquierda=anadir
	def caso4(self,anadir,correo,letra) :				
		aux3=letra					
		while aux3.Empresa<anadir.Empresa and aux3.Derecha!=None:
			aux3=aux3.Derecha				
		if aux3.Empresa==correo.Nombre:
			if(aux3!=None):
				while aux3.AbajoP!=None:	
					aux3=aux3.AbajoP
			aux3.AbajoP=anadir
			anadir.ArribaP=aux3
		else: 
			if aux3.Empresa>anadir.Empresa:										
				aux3=aux3.Izquierda
			anadir.Izquierda=aux3
			if(aux3.Derecha!=None):	
				aux3.Derecha.Izquierda=anadir
				anadir.Derecha=aux3.Derecha			
			aux3.Derecha=anadir			
			aux=correo.Abajo
			while aux.Dep<anadir.Dep and aux.Abajo!=None:	
				aux=aux.Abajo		
			if aux.Dep<anadir.Dep:								
				aux.Abajo=anadir
				anadir.Arriba=aux
			else:	
				aux.Arriba.Abajo=anadir
				anadir.Arriba=aux.Arriba
				anadir.Abajo=aux
				aux.Arriba=anadir	


	def imprimirCorreos(self):
		act=self.Inicio
		while act.Derecha!=None:
			print "["+act.Nombre+"]"
			act=act.Derecha
		print "["+act.Nombre+"]"
		print "I Z Q U I E R D A"
		while act!=None:
			print "["+act.Nombre+"]"
			act=act.Izquierda
	def imprimirLetras(self):
		act=self.Inicio
		while act.Abajo!=None:
			print "["+act.Nombre+"]"
			act=act.Abajo
		print "["+act.Nombre+"]"
		print "I Z Q U I E R D A"
		while act!=None:
			print "["+act.Nombre+"]"
			act=act.Arriba
	def imprimirL(self,letra) :	
		dominio=""
		act=self.buscar(letra)
		if act!=None:			
			while act.Derecha!=None:
				dominio=dominio+ "["+act.Nombre+"]->"
				if act.AbajoP!=None :	
					dominio=dominio+self.imprimirP(act)
				act=act.Derecha
			dominio=dominio+ "["+act.Nombre+"]->"
			if act.AbajoP!=None :	
				dominio=dominio+self.imprimirP(act)
		else :
			dominio="Letra no Existente"
		return dominio

	def imprimirC(self,correo) :
		dominio=""		
		act=self.buscar(correo)
		if act!=None :			
			while act.Abajo!=None:
				dominio=dominio+ "["+act.Nombre+"]->"
				if act.AbajoP!=None :	
					dominio=dominio+self.imprimirP(act)
				act=act.Abajo
			dominio=dominio+ "["+act.Nombre+"]->"
			if act.AbajoP!=None :	
				dominio=dominio+self.imprimirP(act)			
		else:
			dominio="Correo No Existente"
		return dominio	

	def imprimirP(self,letra) :	
		act=letra.AbajoP		
		encontrado=False
		dominio=""
		while act.AbajoP!=None:			
			dominio=dominio+ "["+act.Nombre+"]->"
			act=act.AbajoP
		dominio=dominio+ "["+act.Nombre+"]->"	
		return dominio	

	def eliminar(self,Nombre,Correo,Letra):
		Eliminar=self.buscar(Letra)
		encontrado=False
		while Eliminar!=None and encontrado==False:
			if Eliminar.Correo==Correo:
				encontrado=True
			else:
				Eliminar=Eliminar.Derecha
		encontrado=False
		if Eliminar.Nombre==Nombre :						
			if Eliminar.AbajoP!=None:							
				Aux2=Eliminar.AbajoP
				Aux2.ArribaP=None				
				Aux2.Arriba=Eliminar.Arriba				
				Aux2.Izquierda=Eliminar.Izquierda
				Eliminar.Izquierda.Derecha=Aux2
				Eliminar.Arriba.Abajo=Aux2
				if Eliminar.Derecha!=None:
					Aux2.Derecha=Eliminar.Derecha
					Eliminar.Derecha.Izquierda=Aux2
				if Eliminar.Abajo!=None:
					Aux2.Abajo=Eliminar.Abajo
					Eliminar.Abajo.Arriba=Aux2	
			else :
				if Eliminar.Derecha!=None:
					Eliminar.Derecha.Izquierda=Eliminar.Izquierda
					Eliminar.Izquierda.Derecha=Eliminar.Derecha
				else :
					Eliminar.Izquierda.Derecha=None
				if Eliminar.Abajo!=None:
					Eliminar.Abajo.Arriba=Eliminar.Arriba
					Eliminar.Arriba.Abajo=Eliminar.Abajo
				else :
					Eliminar.Arriba.Abajo=None
					self.EliminarComp(self.buscar(Letra),self.buscar(Correo))	
			Eliminar=None
		else :	
			while Eliminar.AbajoP!=None and encontrado==False:
				Eliminar=Eliminar.AbajoP
				if Eliminar.Nombre==Nombre:
					encontrado=True
			if Eliminar.AbajoP!=None:
				Eliminar.ArribaP.AbajoP=Eliminar.AbajoP
				Eliminar.AbajoP.ArribaP=Eliminar.ArribaP
			else:	
				Eliminar.ArribaP.AbajoP=None
				Eliminar.ArribaP=None
			Eliminar=None				
	
	def EliminarComp(self,Letra,Correo):
		if Letra.Derecha==None:
			if Letra.Abajo!=None:
				Letra.Arriba.Abajo=Letra.Abajo
				Letra.Abajo.Arriba=Letra.Arriba
			else:	
				Letra.Arriba.Abajo=None			
			Letra=None
		if Correo.Abajo==None:
			if Correo.Derecha!=None:
				Correo.Izquierda.Derecha=Correo.Derecha
				Correo.Derecha.Izquierda=Correo.Izquierda
			else:	
				Correo.Izquierda.Derecha=None			
			Correo=None
class ListaSimple:
	 def __init__(self):
	 	self.cabeza=None

	 def insertar(self, palabra):
		 nuevo= Nodo()
		 nuevo.palabra=palabra
		 if self.cabeza is None:
		 	self.setCabeza(nuevo)
		 else:
		 	auxiliar=self.getCabeza()
		 	while(auxiliar.getSiguiente()!=None):
		 		auxiliar=auxiliar.getSiguiente()
		 	auxiliar.setSiguiente(nuevo)
	 def insertar2(self, cod,nombre,descripcion):
		 nuevo= Nodo()
		 nuevo.ID=cod
		 nuevo.nombre=nombre
		 nuevo.descripcion=descripcion
		 if self.cabeza is None:
		 	self.setCabeza(nuevo)
		 else:
		 	auxiliar=self.getCabeza()
		 	while(auxiliar.getSiguiente()!=None):
		 		auxiliar=auxiliar.getSiguiente()
		 	auxiliar.setSiguiente(nuevo)

	 def imprimir(self):
		auxiliar=self.getCabeza()
		while auxiliar:
			print(str(auxiliar.getPalabra()))
			auxiliar=auxiliar.getSiguiente()
	 def imprimir2(self):
	 	auxiliar=self.cabeza
	 	while auxiliar:
	 		print(str(auxiliar.ID)+" "+auxiliar.nombre+auxiliar.descripcion)
			auxiliar=auxiliar.getSiguiente()
	 def eliminar(self, indice):
	 	auxiliar=self.getCabeza()
	 	#i=0
	 	#while auxiliar:
	 	#	if auxiliar.getPalabra()==palabra:
	 	#		return str("EL DATO SE ENCUENTRA EN EL INDICE "+str(i))
	 	#	auxiliar=auxiliar.getSiguiente()
	 	#	i=i+1
	 	#return str("NO SE ENCONTRO EL DATO")
	 	auxiliar=self.getCabeza()
	 	if indice==0:
	 		self.setCabeza(auxiliar.getSiguiente())
	 	else:
	 		for i in range(indice-1):
	 			auxiliar=auxiliar.getSiguiente()
	 		auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente())
	 def eliminar2(self,ID):
	 	self.eliminar(self.buscar2(ID))
	 def buscar(self, palabra):
	 	auxiliar=self.getCabeza()
	 	while auxiliar:
	 		if auxiliar.getPalabra()==palabra:
	 			return True
	 		auxiliar=auxiliar.getSiguiente()
	 	return False
	 def buscar2(self,palabra):
	 	auxiliar=self.getCabeza()
	 	pos=0
	 	while auxiliar:
	 		if auxiliar.ID==palabra:
	 			print("econtrado")
	 			return pos
	 		auxiliar=auxiliar.getSiguiente()
	 		pos=pos+1
	 	return pos
	 		
	 def setCabeza(self, cabeza):
	 	self.cabeza=cabeza
	 def getCabeza(self):
	 	return self.cabeza
class Nodo:
	 def __init__(self):
		self.palabra=None
		self.siguiente=None
		self.ID=None
		self.nombre=None
		self.descripcion=None
		self.rentado=False
	 def getSiguiente(self):
		return self.siguiente
	 def setSiguiente(self,siguiente):
		self.siguiente=siguiente
	 def getPalabra(self):
		return str(self.palabra)
	 def setPalabra(self,palabra):
		self.palabra=str(palabra)

class NodoAVL:
	def __init__(self):
		self.ID=""
		self.nombre=""
		self.descripcion=""
		self.izquierda=None
		self.derecha=None
		self.padre=None
		self.balance=0
		self.rentado=False
class ArbolAVL:
	def __init__(self):
		self.raiz=None
		self.resultado=""
	def insertar(self,ID,nombre,descripcion):
		raiz=self.raiz
		if raiz==None:
			raiz=NodoAVL()
			raiz.ID=ID
			raiz.nombre=nombre
			raiz.descripcion=descripcion
			self.raiz=raiz
		else:
			aux=raiz
			while aux:
				if ID>aux.ID and aux.derecha==None:
					nuevo=NodoAVL()
					nuevo.ID=ID
					nuevo.nombre=nombre
					nuevo.descripcion=descripcion
					aux.derecha=nuevo
					nuevo.padre=aux
					self.balancear(nuevo.padre,1)
					break
				elif ID<aux.ID and aux.izquierda==None:
					nuevo=NodoAVL()
					nuevo.ID=ID
					nuevo.nombre=nombre
					nuevo.descripcion=descripcion
					aux.izquierda=nuevo
					nuevo.padre=aux
					self.balancear(nuevo.padre,-1)
					break
				#ESTE SE PUEDE BORRAR
				elif ID==aux.ID:
					break
				#HASTA ACA
				elif ID>aux.ID:
					aux=aux.derecha
				elif ID<aux.ID:
					aux=aux.izquierda
	def balancear(self,nodo,incremento):
		caso=-1
		while nodo:
			nodo.balance=nodo.balance+incremento
			#print(nodo.balance)
			if nodo.balance==0:
				break
			else:
				caso=self.tipo(nodo)
				if caso==0:
					if nodo.padre!=None:
						
						if nodo.ID<nodo.padre.ID:
							incremento=-1
						else:
							incremento=1
					nodo=nodo.padre
				if caso==1:
					self.izquierdaizquierda(nodo,nodo.derecha)
					break
				if caso==2:
					self.derechaderecha(nodo.derecha,nodo.derecha.izquierda)
					self.izquierdaizquierda(nodo,nodo.derecha)
					break
				if caso==3:
					self.derechaderecha(nodo,nodo.izquierda)
					break
				if caso==4:
					self.izquierdaizquierda(nodo.izquierda,nodo.izquierda.derecha)
					self.derechaderecha(nodo,nodo.izquierda)
					break

	def tipo(self,nodo):
		if nodo.balance==2:
			if nodo.derecha.balance==0 or nodo.derecha.balance==1:
				return 1
			elif nodo.derecha.balance==-1:
				return 2
		elif nodo.balance==-2:
			if nodo.izquierda.balance==0 or nodo.izquierda.balance==-1:
				return 3
			elif nodo.izquierda.balance==1:
				return 4
		return 0
	def izquierdaizquierda(self,nodo,derecha):
		aux=derecha.izquierda
		if nodo==self.raiz:
			self.raiz=derecha
			derecha.padre=None
		else:
			if nodo.ID>nodo.padre.ID:
				nodo.padre.derecha=derecha
			else:
				nodo.padre.izquierda=derecha
			derecha.padre=nodo.padre
		derecha.izquierda=nodo
		nodo.derecha=aux
		nodo.padre=derecha
		if aux!=None:
			aux.padre=nodo
		numero=nodo.balance
		nodo.balance=(numero-1)-max(derecha.balance,0)
		balance2=min(numero-2,numero+derecha.balance-2)
		derecha.balance=min(balance2,derecha.balance-1)
	def derechaderecha(self,nodo,izquierda):
		aux=izquierda.derecha
		if nodo==self.raiz:
			self.raiz=izquierda
			izquierda.padre=None
		else:
			if nodo.ID>nodo.padre.ID:
				nodo.padre.derecha=izquierda
			else:
				nodo.padre.izquierda=izquierda
		izquierda.padre=nodo.padre
		izquierda.derecha=nodo
		nodo.izquierda=aux
		nodo.padre=izquierda
		if aux!=None:
			aux.padre=nodo
		numero=nodo.balance
		nodo.balance=numero+1-min(izquierda.balance,0)
		balance2=min(numero+2,numero-izquierda.balance+2)
		izquierda.balance=max(balance2,izquierda.balance+1)
	def buscar(self,ID):
		if self.raiz!=None:
			actual=self.raiz
			print(ID)
			print(actual.ID)
			while actual:
				if actual.ID==ID:
					print("si")
					return actual
				elif ID<actual:
					print("izquierda")
					actual=actual.izquierda
				elif ID>actual:
					print("drecha")
					actual=actual.derecha
				else:
					actual=None
			return actual
	def eliminar(self,ID):
		if self.raiz!=None:
			self.raiz=None

	def graficar(self):
		self.resultado=""
		if self.raiz!=None:
			self.preorder(self.raiz)
			if self.raiz.derecha==None and self.raiz.izquierda==None:
				self.resultado="\""+str(self.raiz.ID)+"\""
	def activos(self):
		self.resultado=""
		if self.raiz!=None:
			self.preorder2(self.raiz)
		return self.resultado
	def activosDisp(self):
		self.resultado=""
		if self.raiz!=None:
			self.preorder4(self.raiz)
		return self.resultado
	def buscar(self,ID):
		self.resultado=""
		if self.raiz!=None:
			self.preorder3(self.raiz,ID)
		return self.resultado

	def preorder(self,actual):
		if actual.izquierda!=None:
			self.resultado=self.resultado+" \""+actual.ID+"\"->\""+actual.izquierda.ID+"\""
			self.preorder(actual.izquierda)
		if actual.derecha!=None:
			self.resultado=self.resultado+" \""+actual.ID+"\"->\""+actual.derecha.ID+"\""
			self.preorder(actual.derecha)
	def preorder2(self,actual):
			self.resultado=self.resultado+actual.ID+" "
			if actual.izquierda!=None:
				self.preorder2(actual.izquierda)
			if actual.derecha!=None:
				self.preorder2(actual.derecha)
	def preorder3(self,actual,ID):
			if actual.ID==ID:
				self.resultado=actual
			if actual.izquierda!=None:
				self.preorder3(actual.izquierda,ID)
			if actual.derecha!=None:
				self.preorder3(actual.derecha,ID)
	def preorder4(self,actual):
			if actual.rentado==False:
				self.resultado=self.resultado+actual.ID+" "
			if actual.izquierda!=None:
				self.preorder4(actual.izquierda)
			if actual.derecha!=None:
				self.preorder4(actual.derecha)

def stringmatriz():
	print("fdafa")
	auxiliar=mat.Inicio
	auxiliar2=auxiliar
	resultado="digraph G{"
	while auxiliar2:
		auxiliar=auxiliar2
		while auxiliar:
			if auxiliar.Derecha!=None:
				resultado=resultado+'"'+auxiliar.Nombre+'"->"'+auxiliar.Derecha.Nombre+'" '
			if auxiliar.Izquierda!=None:
				resultado=resultado+'"'+auxiliar.Nombre+'"->"'+auxiliar.Izquierda.Nombre+'" '
			if auxiliar.Arriba!=None:
				resultado=resultado+'"'+auxiliar.Nombre+'"->"'+auxiliar.Arriba.Nombre+'" '
			if auxiliar.Abajo!=None:
				resultado=resultado+'"'+auxiliar.Nombre+'"->"'+auxiliar.Abajo.Nombre+'" '
			if auxiliar.AbajoP!=None:
				auxiliar3=auxiliar
				while auxiliar3.AbajoP:
					resultado=resultado+'"'+auxiliar3.Nombre+'"->"'+auxiliar3.AbajoP.Nombre+'" '
					resultado=resultado+'"'+auxiliar3.AbajoP.Nombre+'"->"'+auxiliar3.Nombre+'" '
					auxiliar3=auxiliar3.AbajoP
			auxiliar=auxiliar.Derecha
		auxiliar2=auxiliar2.Abajo
	resultado=resultado+"}"
	return resultado
	 
def creartxtmatriz():
	 archi=open('matriz.txt','w')
	 archi.close
	 crearmatriz()
def crearmatriz():
    archi=open('matriz.txt','a')
    archi.write("digraph G {")
    auxiliar=mat.Inicio
    auxiliar2=auxiliar
    while auxiliar2:
    	auxiliar=auxiliar2
    	while auxiliar:
    		if auxiliar.Derecha!=None:
    			archi.write('"'+auxiliar.Nombre+'"->"'+auxiliar.Derecha.Nombre+'" ')
    		if auxiliar.Izquierda!=None:
    			archi.write('"'+auxiliar.Nombre+'"->"'+auxiliar.Izquierda.Nombre+'" ')
    		if auxiliar.Arriba!=None:
    			archi.write('"'+auxiliar.Nombre+'"->"'+auxiliar.Arriba.Nombre+'" ')
    		if auxiliar.Abajo!=None:
    			archi.write('"'+auxiliar.Nombre+'"->"'+auxiliar.Abajo.Nombre+'" ')
    		if auxiliar.AbajoP!=None:
    			auxiliar3=auxiliar
    			while auxiliar3.AbajoP:
    				archi.write('"'+auxiliar3.Nombre+'"->"'+auxiliar3.AbajoP.Nombre+'" ')
    				archi.write('"'+auxiliar3.AbajoP.Nombre+'"->"'+auxiliar3.Nombre+'" ')
    				auxiliar3=auxiliar3.AbajoP
    		auxiliar=auxiliar.Derecha
    	auxiliar2=auxiliar2.Abajo
    archi.write("}")
    archi.close()
    ejecutar("matriz")
def stringAVL(user,empresa,departamento):
	resultado="digraph G {"
	usuario=mat.buscarUser(user,empresa,departamento)
	if usuario!=None:
		usuario.arbol.graficar()
		resultado=resultado+usuario.arbol.resultado
	resultado=resultado+"}"
	return resultado


def creartxtAVL(usuario):
	 archi=open('AVL.txt','w')
	 archi.close
	 #print(usuario.arbol.raiz.nombre)
	 crearAVL(usuario)
def crearAVL(usuario):
    archi=open('AVL.txt','a')
    archi.write("digraph G {")
    usuario.arbol.graficar()
    archi.write(usuario.arbol.resultado)
    archi.write("}")
    archi.close()
    ejecutar("AVL")	
def ejecutar(nombre):
	import os
	dotPath = "C:\\Graphviz2.30\\bin\\dot.exe"
	fileInputPath = "C:\\Estructuras\\Proyecto\\"+nombre+".txt"
	fileOutputPath = "C:\\Estructuras\\Proyecto\\"+nombre+".jpg"
	tParam = " -Tjpg "
	tOParam = " -o "
	tuple = (dotPath +tParam+ fileInputPath+tOParam+fileOutputPath)
	os.system(tuple)
def registrarse(usuario,empresa,departamento,contrasena,completo):
	mat.insertar(usuario,empresa,departamento,contrasena,completo)
	creartxtmatriz()
def buscarusuario(usuario,empresa,departamento,contrasena):
	actual=mat.buscarUser(usuario,empresa,departamento)
	if actual!=None:
		if actual.contrasena==contrasena:
			print("Puede entrar")
		else:
			print("contrasena incorrecta")
	else:
		print("no existe")
def codigo():
	cod=""
	x=0
	while x<15:
		 cod=cod+choice("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")
		 x=x+1
	return cod
def agregaractivo(usuario,nombre,descripcion):
	cod=codigo()
	valido=False
	while valido==False:
		cod=codigo()
		if codigos.buscar(cod)==False:
			codigos.insertar(cod)
			valido=True
	#print(usuario.Nombre+","+usuario.Empresa+","+usuario.Dep)	
	usuario.arbol.insertar(cod,nombre,descripcion)
	usuario.lista.insertar2(cod,nombre,descripcion)
	creartxtAVL(usuario)
def eliminaractivo(usuario,ID):
	usuario.lista.eliminar2(ID)
	cabe=usuario.lista.getCabeza()
	usuario.arbol.raiz=None
	while cabe:
		usuario.arbol.insertar(cabe.ID,cabe.nombre,cabe.descripcion)
		cabe=cabe.getSiguiente()
	creartxtAVL(usuario)
def modificaractivo(usuario,ID,descripcion):
	actual=usuario.arbol.buscar(ID)
	actual.descripcion=descripcion
def activosUsuario(user,empresa,departamento):
	usuario=mat.buscarUser(user,empresa,departamento)
	return usuario.arbol.activos()
def todosActivos():
	resultado=""
	aux=mat.Inicio
	while aux:
		aux2=aux
		while aux2:
			aux3=aux2.AbajoP
			while aux3:
				if aux3.arbol.raiz!=None:
					resultado=resultado+aux3.arbol.activos()
				aux3=aux3.AbajoP
			if aux2.arbol.raiz!=None:
				resultado=resultado+aux2.arbol.activos()
			aux2=aux2.Derecha
		aux=aux.Abajo
	return resultado
def activosDisponibles():
	resultado=""
	aux=mat.Inicio
	while aux:
		aux2=aux
		while aux2:
			aux3=aux2.AbajoP
			while aux3:
				if aux3.arbol.raiz!=None:
					resultado=resultado+aux3.arbol.activosDisp()
				aux3=aux3.AbajoP
			if aux2.arbol.raiz!=None:
				resultado=resultado+aux2.arbol.activosDisp()
			aux2=aux2.Derecha
		aux=aux.Abajo
	return resultado
def buscarnombre(ID):
	resultado=""
	aux=mat.Inicio
	while aux:
		aux2=aux
		while aux2:
			aux3=aux2.AbajoP
			while aux3:
				if aux3.arbol.raiz!=None:
					if aux3.arbol.buscar(ID)!=None:
						return aux3.arbol.buscar(ID)
				aux3=aux3.AbajoP
			if aux2.arbol.raiz!=None:
				if aux2.arbol.buscar(ID)!=None:
						return aux2.arbol.buscar(ID)
			aux2=aux2.Derecha
		aux=aux.Abajo
def bandTrue(ID):
	resultado=""
	aux=mat.Inicio
	while aux:
		aux2=aux
		while aux2:
			aux3=aux2.AbajoP
			while aux3:
				if aux3.arbol.raiz!=None:
					if aux3.arbol.buscar(ID)!=None:
						aux3.arbol.buscar(ID).rentado=True
				aux3=aux3.AbajoP
			if aux2.arbol.raiz!=None:
				if aux2.arbol.buscar(ID)!=None:
						aux2.arbol.buscar(ID).rentado=True
			aux2=aux2.Derecha
		aux=aux.Abajo
def bandFalse(ID):
	resultado=""
	aux=mat.Inicio
	while aux:
		aux2=aux
		while aux2:
			aux3=aux2.AbajoP
			while aux3:
				if aux3.arbol.raiz!=None:
					if aux3.arbol.buscar(ID)!=None:
						aux3.arbol.buscar(ID).rentado=False
				aux3=aux3.AbajoP
			if aux2.arbol.raiz!=None:
				if aux2.arbol.buscar(ID)!=None:
						aux2.arbol.buscar(ID).rentado=False
			aux2=aux2.Derecha
		aux=aux.Abajo

from flask import Flask, request, Response
app = Flask("EDD_codigo_ejemplo")

mat=Matriz()
codigos=ListaSimple()

@app.route('/metodoWeb',methods=['POST']) 
def hello():
	parametro = str(request.form['dato'])
	dato2 = str(request.form['dato2'])
	return "Hola"

@app.route("/e")
def hellof():
	return "Hello World2!"

@app.route("/insertarMatriz",methods=['POST'])
def helloa():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	contrasena=str(request.form['dato4'])
	completo=str(request.form['dato5'])
	registrarse(user,empresa,departamento,contrasena,completo)
	return "Registrado"

@app.route("/login",methods=['POST'])
def hellob():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	contrasena=str(request.form['dato4'])
	actual=mat.buscarUser(user,empresa,departamento)
	mensaje=""
	if actual!=None:
		if actual.contrasena==contrasena:
			mensaje="Puede entrar"
		else:
			mensaje="contrasena incorrecta"
	else:
		mensaje="no existe"
	return mensaje
@app.route("/agregarActivo",methods=['POST'])
def helloc():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	articulo=str(request.form['dato4'])
	descripcion=str(request.form['dato5'])
	usuario=mat.buscarUser(user,empresa,departamento)
	agregaractivo(usuario,articulo,descripcion)
	return  "agregado"

@app.route("/modificarActivo",methods=['POST'])
def hellod():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	codarticulo=str(request.form['dato4'])
	descripcion=str(request.form['dato5'])
	usuario=mat.buscarUser(user,empresa,departamento)
	modificaractivo(usuario,codarticulo,descripcion)
	return  "modificado"

@app.route("/eliminarActivo",methods=['POST'])
def helloe():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	codarticulo=str(request.form['dato4'])
	usuario=mat.buscarUser(user,empresa,departamento)
	eliminaractivo(usuario,codarticulo)
	return  "eliminado"

@app.route("/graficarMatriz",methods=['POST'])
def hellog():
	user=str(request.form['dato1'])
	resultado=stringmatriz()
	return  resultado

@app.route("/graficarEmpresa",methods=['POST'])
def helloh():
	empresa=str(request.form['dato1'])
	empre=mat.buscarempresa(empresa)
	resultado="digraph G{ "
	if empre!=None:
		while empre:
			auxiliar3=None
			if empre.AbajoP!=None:
				auxiliar3=empre
				while auxiliar3.AbajoP:
					resultado=resultado+auxiliar3.Nombre+"->"+auxiliar3.AbajoP.Nombre+" "
					auxiliar3=auxiliar3.AbajoP
			if auxiliar3!=None and empre.Abajo!=None:
				resultado=resultado+auxiliar3.Nombre+"->"+empre.Abajo.Nombre+" "
			elif empre.Abajo!=None:
				resultado=resultado+empre.Nombre+"->"+empre.Abajo.Nombre+" "
			empre=empre.Abajo
	resultado=resultado+"}"
	return  resultado

@app.route("/graficarDepartamento",methods=['POST'])
def helloi():
	departamento=str(request.form['dato1'])
	dep=mat.buscarDep(departamento)
	resultado="digraph G{ "
	if dep!=None:
		while dep:
			auxiliar3=None
			if dep.AbajoP!=None:
				auxiliar3=dep
				while auxiliar3.AbajoP:
					resultado=resultado+auxiliar3.Nombre+"->"+auxiliar3.AbajoP.Nombre+" "
					auxiliar3=auxiliar3.AbajoP
			if auxiliar3!=None and dep.Derecha!=None:
				resultado=resultado+auxiliar3.Nombre+"->"+dep.Derecha.Nombre+" "
			elif dep.Derecha!=None:
				resultado=resultado+dep.Nombre+"->"+dep.Derecha.Nombre+" "
			dep=dep.Derecha
	resultado=resultado+"}"
	return  resultado

@app.route("/graficarAVL",methods=['POST'])
def helloj():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	resultado=stringAVL(user,empresa,departamento)
	return resultado

@app.route("/activosUsuario",methods=['POST'])
def hellok():
	user=str(request.form['dato1'])
	empresa=str(request.form['dato2'])
	departamento=str(request.form['dato3'])
	resultado=activosUsuario(user,empresa,departamento)
	return resultado

@app.route("/todosActivos",methods=['POST'])
def hellol():
	user=str(request.form['dato1'])
	resultado=todosActivos()
	return resultado

@app.route("/devolverNombre",methods=['POST'])
def hellom():
	ID=str(request.form['dato1'])
	resultado=buscarnombre(ID).nombre
	return resultado
@app.route("/devolverDescripcion",methods=['POST'])
def hellon():
	ID=str(request.form['dato1'])
	resultado=buscarnombre(ID).descripcion
	return resultado

@app.route("/banderaTrue",methods=['POST'])
def helloo():
	ID=str(request.form['dato1'])
	resultado=bandTrue(ID)
	return "1"
@app.route("/banderaFalse",methods=['POST'])
def hellop():
	ID=str(request.form['dato1'])
	resultado=bandFalse(ID)
	return "0"

@app.route("/activosDisponibles",methods=['POST'])
def helloq():
	user=str(request.form['dato1'])
	resultado=activosDisponibles()
	return resultado

if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0')

print("termino")