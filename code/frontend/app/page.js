import { Button } from "@/components/ui/button";
import Image from "next/image";
import Link from "next/link";

export default function Home() {
  return (
    <>
      <div className="flex justify-around w-[100vw] h-[100vh] pt-20">
        <Button>
          <Link href="/cliente">Cadastrar Cliente</Link>
        </Button>
        <Button>
          <Link href="/empresa">Cadastrar Empresa</Link>
        </Button>
        <Button>
          <Link href="/banco">Cadastrar Banco</Link>
        </Button>
        <Button>
          <Link href="/emprestimo">Cadastrar Emprestimo</Link>
        </Button>
      </div>
    </>
  );
}
