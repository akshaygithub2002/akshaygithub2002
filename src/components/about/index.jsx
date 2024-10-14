import React from "react";
import ItemLayout from "./ItemLayout";
import Link from "next/link";

const AboutDetails = () => {
  return (
    <section className="py-20 w-full">
      <div className="grid grid-cols-12 gap-4 xs:gap-6  md:gap-8 w-full">
        <ItemLayout
          className={
            " col-span-full lg:col-span-8 row-span-2 flex-col items-start"
          }
        >
          <h2 className="  text-xl md:text-2xl text-left w-full capitalize">
            Architect of Enchantment
          </h2>
          <p className="font-light  text-xs sm:text-sm md:text-base   ">
            As a fresher Full Stack Java Developer, I am embarking on a journey to master both front-end and back-end technologies. My expertise in Java forms the backbone of my development skills, allowing me to build robust, scalable, and efficient server-side applications. On the front-end, I am skilled in crafting interactive user interfaces using HTML, CSS, and JavaScript, with frameworks like React.js to enhance user experiences.

            With Spring Boot and Hibernate, I manage databases and server logic seamlessly, ensuring smooth data flow between the front-end and back-end. I also utilize RESTful APIs to connect different parts of the application and ensure reliable communication between them.

            In addition, I am continually exploring new tools and technologies such as Microservices, Docker, and Kubernetes to create modern, cloud-ready applications. With a passion for learning and innovation, I am excited to contribute to dynamic development teams, solving real-world problems and shaping the future of web applications.</p>
        </ItemLayout>

        <ItemLayout
          className={" col-span-full xs:col-span-6 lg:col-span-4 text-accent"}
        >
          <p className="font-semibold w-full text-left text-2xl sm:text-5xl">
            <sub className="font-bold text-bold">Full Stack Java Developer</sub>
          </p>
        </ItemLayout>

        <ItemLayout
          className={"col-span-full xs:col-span-6 lg:col-span-4 text-accent"}
        >
          <p className="font-semibold w-full text-left text-2xl sm:text-5xl">
            Fresher {" "}
            <sub className="font-semibold text-base"></sub>
          </p>
        </ItemLayout>

        <ItemLayout
          className={"  col-span-4 !p-0"}
        >
          <img
            className="w-full h-auto"
            src="https://github-readme-stats.vercel.app/api/top-langs/?username=Akshaysonawane&theme=transparent&hide_border=true&title_color=FEFE5B&text_color=FFFFFF&text_bold=false" alt="CodeBucks"
            loading="lazy"
          />

        </ItemLayout>

        <ItemLayout className={"col-span-full sm:col-span-6 md:col-span-8 !p-0"}>
          <img
            className="w-full h-auto"
            src="https://github-readme-stats.vercel.app/api?username=Akshaysonawane&theme=transparent&hide_border=true&title_color=FEFE5B&text_color=FFFFFF&text_bold=false" alt="CodeBucks"

            loading="lazy"
          />
        </ItemLayout>

        <ItemLayout className={"col-span-full"}>
          <img
            className="w-full h-auto"
            src={`https://skillicons.dev/icons?i=appwrite,aws,babel,bootstrap,cloudflare,css,d3,docker,figma,firebase,gatsby,git,github,graphql,html,ipfs,js,jquery,kubernetes,linux,mongodb,mysql,netlify,nextjs,nodejs,npm,postgres,react,redux,replit,sass,supabase,tailwind,threejs,vercel,vite,vscode,yarn`}
            alt="CodeBucks"
            loading="lazy"
          />
        </ItemLayout>

        <ItemLayout className={"col-span-4 !p-0"}>
          <img src="https://github-readme-streak-stats.herokuapp.com?user=Akshaysonawane&theme=dark&type=png&border=EB54540B&ring=F9FF49&currStreakLabel=E0EB2E" alt="GitHub Streak" />
        </ItemLayout>


        <ItemLayout
          className={"  col-span-8 !p-0"}
        >
          <img
            className="w-full h-auto"
            src="https://github-readme-stats.vercel.app/api/pin/?username=anuraghazra&repo=github-readme-stats&theme=transparent&hide_border=true&title_color=FEFE5B&text_color=FFFFFF&icon_color=FEFE5B&text_bold=false&p al" alt="CodeBucks"
            loading="lazy"
          />

        </ItemLayout>
      </div>
    </section>
  );
};

export default AboutDetails;
